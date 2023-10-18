Name FACET

# Defines
!define REGKEY "SOFTWARE\$(^Name)"
!define VERSION 1.0.0
!define COMPANY "Indiana University"
!define URL ""
!define MUI_ICON "${NSISDIR}\Contrib\Graphics\Icons\modern-install.ico"
!define MUI_FINISHPAGE_NOAUTOCLOSE
!define MUI_STARTMENUPAGE_REGISTRY_ROOT HKLM
!define MUI_STARTMENUPAGE_REGISTRY_KEY ${REGKEY}
!define MUI_STARTMENUPAGE_REGISTRY_VALUENAME StartMenuGroup
!define MUI_STARTMENUPAGE_DEFAULTFOLDER FACET
!define MUI_UNICON "${NSISDIR}\Contrib\Graphics\Icons\facet.ico"
!define MUI_UNFINISHPAGE_NOAUTOCLOSE
 !define MUI_FINISHPAGE_RUN
 !define MUI_FINISHPAGE_RUN_TEXT "Create desktop shortcut"
 !define MUI_FINISHPAGE_RUN_FUNCTION "myfunction" 

# Included files
!include Sections.nsh
!include MUI.nsh

# Variables
Var StartMenuGroup

# Installer pages
!insertmacro MUI_PAGE_WELCOME
!insertmacro MUI_PAGE_LICENSE "IU Sound Directions License.rtf"
!insertmacro MUI_PAGE_DIRECTORY
!insertmacro MUI_PAGE_STARTMENU Application $StartMenuGroup
!insertmacro MUI_PAGE_INSTFILES
!insertmacro MUI_PAGE_FINISH
!insertmacro MUI_UNPAGE_CONFIRM
!insertmacro MUI_UNPAGE_INSTFILES

# Installer languages
!insertmacro MUI_LANGUAGE English

# Installer attributes
OutFile setup.exe
Icon "${NSISDIR}\Contrib\Graphics\Icons\modern-install.ico"
InstallDir $PROGRAMFILES\FACET
CRCCheck on
XPStyle on
ShowInstDetails show
VIProductVersion 1.0.0.0
VIAddVersionKey ProductName FACET
VIAddVersionKey ProductVersion "${VERSION}"
VIAddVersionKey CompanyName "${COMPANY}"
VIAddVersionKey FileVersion "${VERSION}"
VIAddVersionKey FileDescription ""
VIAddVersionKey LegalCopyright ""
InstallDirRegKey HKLM "${REGKEY}" Path
ShowUninstDetails show

# Installer sections
Section -Main SEC0000
    SetShellVarContext all
    SetOutPath $INSTDIR
    SetOverwrite on
    File run.bat
    File run_TEST.bat
    File data.dat
    File readme.rtf
    File "IU Sound Directions License.rtf"
    File facet.jar
    SetOutPath $INSTDIR\images
    File /r images\*
    SetOutPath $INSTDIR\JRE
    File /r "C:\Program Files\Java\JRE\*"
     SetOutPath $INSTDIR 
    
    ;remove old shortcuts
    Delete "$SMPROGRAMS\FACET\FACET 0.98.lnk"
    Delete "$DESKTOP\FACET 0.98.lnk" 
     Delete "$SMPROGRAMS\FACET\FACET 0.985.lnk"
    Delete "$DESKTOP\FACET 0.985.lnk" 
    Delete "$SMPROGRAMS\FACET\FACET 0.99.lnk"
    Delete "$DESKTOP\FACET 0.99.lnk" 
     Delete "$SMPROGRAMS\FACET\FACET 0.991.lnk"
    Delete "$DESKTOP\FACET 0.991.lnk" 
     Delete "$SMPROGRAMS\FACET\FACET 0.992.lnk"
    Delete "$DESKTOP\FACET 0.992.lnk" 
    Delete "$SMPROGRAMS\FACET\FACET 0.993.lnk"
    Delete "$DESKTOP\FACET 0.993.lnk" 
    Delete "$SMPROGRAMS\FACET\FACET 0.994.lnk"
    Delete "$DESKTOP\FACET 0.994.lnk" 
    Delete "$SMPROGRAMS\FACET\FACET 0.995.lnk"
    Delete "$DESKTOP\FACET 0.995.lnk" 
    Delete "$SMPROGRAMS\FACET\FACET 0.996.lnk"
    Delete "$DESKTOP\FACET 0.996.lnk" 
     Delete "$SMPROGRAMS\FACET\FACET 0.997.lnk"
    Delete "$DESKTOP\FACET 0.997.lnk" 
    
    ;create start-menu items
    CreateDirectory "$SMPROGRAMS\FACET"
    CreateShortCut "$SMPROGRAMS\FACET\FACET 1.0.lnk"  "$INSTDIR\run.bat" "$INSTDIR\images\facet.ico" "$INSTDIR\run.bat"   0
    CreateShortCut "$SMPROGRAMS\FACET\License.lnk"  "$INSTDIR\IU Sound Directions License.rtf" "" "$INSTDIR\IU Sound Directions License.rtf"   0
    CreateShortCut "$SMPROGRAMS\FACET\Read Me.lnk"  "$INSTDIR\readme.rtf" "" "$INSTDIR\readme.rtf"   0
    CreateShortCut "$SMPROGRAMS\FACET\Sound Directions Web Site.lnk"  "http://www.dlib.indiana.edu/projects/sounddirections/facet/" "" "http://www.dlib.indiana.edu/projects/sounddirections/facet/"   0
    
    WriteRegStr HKLM "${REGKEY}\Components" Main 1
SectionEnd

 Function "myfunction"
     ;create desktop shortcut
    CreateShortCut "$DESKTOP\FACET 1.0.lnk" "$INSTDIR\run.bat" "" "$INSTDIR\images\facet.ico"
FunctionEnd

Section -post SEC0001
    WriteRegStr HKLM "${REGKEY}" Path $INSTDIR
    SetOutPath $INSTDIR
    WriteUninstaller $INSTDIR\uninstall.exe
    !insertmacro MUI_STARTMENU_WRITE_BEGIN Application
    !insertmacro MUI_STARTMENU_WRITE_END
    WriteRegStr HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" DisplayName "$(^Name)"
    WriteRegStr HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" DisplayVersion "${VERSION}"
    WriteRegStr HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" Publisher "${COMPANY}"
    WriteRegStr HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" DisplayIcon $INSTDIR\uninstall.exe
    WriteRegStr HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" UninstallString $INSTDIR\uninstall.exe
    WriteRegDWORD HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" NoModify 1
    WriteRegDWORD HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)" NoRepair 1
SectionEnd

# Macro for selecting uninstaller sections
!macro SELECT_UNSECTION SECTION_NAME UNSECTION_ID
    Push $R0
    ReadRegStr $R0 HKLM "${REGKEY}\Components" "${SECTION_NAME}"
    StrCmp $R0 1 0 next${UNSECTION_ID}
    !insertmacro SelectSection "${UNSECTION_ID}"
    GoTo done${UNSECTION_ID}
next${UNSECTION_ID}:
    !insertmacro UnselectSection "${UNSECTION_ID}"
done${UNSECTION_ID}:
    Pop $R0
!macroend

# Uninstaller sections
Section /o -un.Main UNSEC0000
  SetShellVarContext all
         Delete  "$DESKTOP\FACET 1.0.lnk"
          Delete  "$DESKTOP\License.lnk"
           Delete  "$DESKTOP\\Read Me.lnk"
           Delete  "$DESKTOP\\Sound Directions Web Site.lnk"
    RmDir /r $SMPROGRAMS\$StartMenuGroup
    RmDir /r /REBOOTOK $INSTDIR\JRE
    RmDir /r /REBOOTOK $INSTDIR\images
    Delete /REBOOTOK $INSTDIR\facet.jar
    Delete /REBOOTOK $INSTDIR\data.dat
    Delete /REBOOTOK $INSTDIR\run.bat
    Delete /REBOOTOK $INSTDIR\run_TEST.bat
    Delete /REBOOTOK $INSTDIR\readme.rtf
    Delete /REBOOTOK "$INSTDIR\IU Sound Directions License.rtf"
    DeleteRegValue HKLM "${REGKEY}\Components" Main    
    
SectionEnd

Section -un.post UNSEC0001
 SetShellVarContext all
    DeleteRegKey HKLM "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\$(^Name)"
    Delete /REBOOTOK $INSTDIR\uninstall.exe
    DeleteRegValue HKLM "${REGKEY}" StartMenuGroup
    DeleteRegValue HKLM "${REGKEY}" Path
    DeleteRegKey /IfEmpty HKLM "${REGKEY}\Components"
    DeleteRegKey /IfEmpty HKLM "${REGKEY}"
     

    RmDir  $INSTDIR
    
    Push $R0
    StrCpy $R0 $StartMenuGroup 1
    StrCmp $R0 ">" no_smgroup
no_smgroup:
    Pop $R0
SectionEnd

# Installer functions
Function .onInit
    InitPluginsDir
FunctionEnd

# Uninstaller functions
Function un.onInit
    ReadRegStr $INSTDIR HKLM "${REGKEY}" Path
    !insertmacro MUI_STARTMENU_GETFOLDER Application $StartMenuGroup
    !insertmacro SELECT_UNSECTION Main ${UNSEC0000}
FunctionEnd

