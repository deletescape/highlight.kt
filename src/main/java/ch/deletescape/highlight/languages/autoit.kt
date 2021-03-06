package ch.deletescape.highlight.languages
import ch.deletescape.highlight.core.*
/*
Language = AutoIt
Author = Manh Tuan <junookyo@gmail.com>
Description = AutoIt language definition
Category = scripting
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/autoit.js MD5 <488b03d4a95baeba2e9368542c9c5ba6>
 */
internal fun autoit(): Mode {
    var KEYWORDS = "ByRef Case Const ContinueCase ContinueLoop Default Dim Do Else ElseIf EndFunc EndIf EndSelect EndSwitch EndWith Enum Exit ExitLoop For Func Global If In Local Next ReDim Return Select Static Step Switch Then To Until Volatile WEnd While With"
    var LITERAL = "True False And Null Not Or"
    var BUILT_IN =
        "Abs ACos AdlibRegister AdlibUnRegister Asc AscW ASin Assign ATan AutoItSetOption AutoItWinGetTitle AutoItWinSetTitle Beep Binary BinaryLen BinaryMid BinaryToString BitAND BitNOT BitOR BitRotate BitShift BitXOR BlockInput Break Call CDTray Ceiling Chr ChrW ClipGet ClipPut ConsoleRead ConsoleWrite ConsoleWriteError ControlClick ControlCommand ControlDisable ControlEnable ControlFocus ControlGetFocus ControlGetHandle ControlGetPos ControlGetText ControlHide ControlListView ControlMove ControlSend ControlSetText ControlShow ControlTreeView Cos Dec DirCopy DirCreate DirGetSize DirMove DirRemove DllCall DllCallAddress DllCallbackFree DllCallbackGetPtr DllCallbackRegister DllClose DllOpen DllStructCreate DllStructGetData DllStructGetPtr DllStructGetSize DllStructSetData DriveGetDrive DriveGetFileSystem DriveGetLabel DriveGetSerial DriveGetType DriveMapAdd DriveMapDel DriveMapGet DriveSetLabel DriveSpaceFree DriveSpaceTotal DriveStatus EnvGet EnvSet EnvUpdate Eval Execute Exp FileChangeDir FileClose FileCopy FileCreateNTFSLink FileCreateShortcut FileDelete FileExists FileFindFirstFile FileFindNextFile FileFlush FileGetAttrib FileGetEncoding FileGetLongName FileGetPos FileGetShortcut FileGetShortName FileGetSize FileGetTime FileGetVersion FileInstall FileMove FileOpen FileOpenDialog FileRead FileReadLine FileReadToArray FileRecycle FileRecycleEmpty FileSaveDialog FileSelectFolder FileSetAttrib FileSetEnd FileSetPos FileSetTime FileWrite FileWriteLine Floor FtpSetProxy FuncName GUICreate GUICtrlCreateAvi GUICtrlCreateButton GUICtrlCreateCheckbox GUICtrlCreateCombo GUICtrlCreateContextMenu GUICtrlCreateDate GUICtrlCreateDummy GUICtrlCreateEdit GUICtrlCreateGraphic GUICtrlCreateGroup GUICtrlCreateIcon GUICtrlCreateInput GUICtrlCreateLabel GUICtrlCreateList GUICtrlCreateListView GUICtrlCreateListViewItem GUICtrlCreateMenu GUICtrlCreateMenuItem GUICtrlCreateMonthCal GUICtrlCreateObj GUICtrlCreatePic GUICtrlCreateProgress GUICtrlCreateRadio GUICtrlCreateSlider GUICtrlCreateTab GUICtrlCreateTabItem GUICtrlCreateTreeView GUICtrlCreateTreeViewItem GUICtrlCreateUpdown GUICtrlDelete GUICtrlGetHandle GUICtrlGetState GUICtrlRead GUICtrlRecvMsg GUICtrlRegisterListViewSort GUICtrlSendMsg GUICtrlSendToDummy GUICtrlSetBkColor GUICtrlSetColor GUICtrlSetCursor GUICtrlSetData GUICtrlSetDefBkColor GUICtrlSetDefColor GUICtrlSetFont GUICtrlSetGraphic GUICtrlSetImage GUICtrlSetLimit GUICtrlSetOnEvent GUICtrlSetPos GUICtrlSetResizing GUICtrlSetState GUICtrlSetStyle GUICtrlSetTip GUIDelete GUIGetCursorInfo GUIGetMsg GUIGetStyle GUIRegisterMsg GUISetAccelerators GUISetBkColor GUISetCoord GUISetCursor GUISetFont GUISetHelp GUISetIcon GUISetOnEvent GUISetState GUISetStyle GUIStartGroup GUISwitch Hex HotKeySet HttpSetProxy HttpSetUserAgent HWnd InetClose InetGet InetGetInfo InetGetSize InetRead IniDelete IniRead IniReadSection IniReadSectionNames IniRenameSection IniWrite IniWriteSection InputBox Int IsAdmin IsArray IsBinary IsBool IsDeclared IsDllStruct IsFloat IsFunc IsHWnd IsInt IsKeyword IsNumber IsObj IsPtr IsString Log MemGetStats Mod MouseClick MouseClickDrag MouseDown MouseGetCursor MouseGetPos MouseMove MouseUp MouseWheel MsgBox Number ObjCreate ObjCreateInterface ObjEvent ObjGet ObjName OnAutoItExitRegister OnAutoItExitUnRegister Ping PixelChecksum PixelGetColor PixelSearch ProcessClose ProcessExists ProcessGetStats ProcessList ProcessSetPriority ProcessWait ProcessWaitClose ProgressOff ProgressOn ProgressSet Ptr Random RegDelete RegEnumKey RegEnumVal RegRead RegWrite Round Run RunAs RunAsWait RunWait Send SendKeepActive SetError SetExtended ShellExecute ShellExecuteWait Shutdown Sin Sleep SoundPlay SoundSetWaveVolume SplashImageOn SplashOff SplashTextOn Sqrt SRandom StatusbarGetText StderrRead StdinWrite StdioClose StdoutRead String StringAddCR StringCompare StringFormat StringFromASCIIArray StringInStr StringIsAlNum StringIsAlpha StringIsASCII StringIsDigit StringIsFloat StringIsInt StringIsLower StringIsSpace StringIsUpper StringIsXDigit StringLeft StringLen StringLower StringMid StringRegExp StringRegExpReplace StringReplace StringReverse StringRight StringSplit StringStripCR StringStripWS StringToASCIIArray StringToBinary StringTrimLeft StringTrimRight StringUpper Tan TCPAccept TCPCloseSocket TCPConnect TCPListen TCPNameToIP TCPRecv TCPSend TCPShutdown, UDPShutdown TCPStartup, UDPStartup TimerDiff TimerInit ToolTip TrayCreateItem TrayCreateMenu TrayGetMsg TrayItemDelete TrayItemGetHandle TrayItemGetState TrayItemGetText TrayItemSetOnEvent TrayItemSetState TrayItemSetText TraySetClick TraySetIcon TraySetOnEvent TraySetPauseIcon TraySetState TraySetToolTip TrayTip UBound UDPBind UDPCloseSocket UDPOpen UDPRecv UDPSend VarGetType WinActivate WinActive WinClose WinExists WinFlash WinGetCaretPos WinGetClassList WinGetClientSize WinGetHandle WinGetPos WinGetProcess WinGetState WinGetText WinGetTitle WinKill WinList WinMenuSelectItem WinMinimizeAll WinMinimizeAllUndo WinMove WinSetOnTop WinSetState WinSetTitle WinSetTrans WinWait"
    var COMMENT = Mode(
        variants = listOf(
            hljs.COMMENT(
                ";",
                "$",
                Mode(relevance = 0)
            ),
            hljs.COMMENT(
                "#cs",
                "#ce"
            ),
            hljs.COMMENT(
                "#comments-start",
                "#comments-end"
            )
        )
    )
    var VARIABLE = Mode(
        begin = "\\\$[A-z0-9_]+"
    )
    var STRING = Mode(
        className = "string",
        variants = listOf(
            Mode(
                begin =
                    """"""",
                end =
                    """"""",
                contains = listOf(
                    Mode(
                        begin =
                            """""""",
                        relevance = 0
                    )
                )
            ),
            Mode(
                begin =
                    """'""",
                end =
                    """'""",
                contains = listOf(
                    Mode(
                        begin =
                            """''""",
                        relevance = 0
                    )
                )
            )
        )
    )
    var NUMBER = Mode(
        variants = listOf(hljs.BINARY_NUMBER_MODE, hljs.C_NUMBER_MODE)
    )
    var PREPROCESSOR = Mode(
        className = "meta",
        begin = "#",
        end = "$",
        keywords = keyword(
                className = "meta-keyword",
                value = "comments include include-once NoTrayIcon OnAutoItStartRegister pragma compile RequireAdmin"
            ),
        contains = listOf(
            Mode(
                begin =
                    """\\\n""",
                relevance = 0
            ),
            Mode(
                beginKeywords = keywords("include"),
                keywords = keyword(
                        className = "meta-keyword",
                        value = "include"
                    ),
                end = "$",
                contains = listOf(
                    STRING,
                    Mode(
                        className = "meta-string",
                        variants = listOf(
                            Mode(
                                begin = "<",
                                end = ">"
                            ),
                            Mode(
                                begin =
                                    """"""",
                                end =
                                    """"""",
                                contains = listOf(
                                    Mode(
                                        begin =
                                            """""""",
                                        relevance = 0
                                    )
                                )
                            ),
                            Mode(
                                begin =
                                    """'""",
                                end =
                                    """'""",
                                contains = listOf(
                                    Mode(
                                        begin =
                                            """''""",
                                        relevance = 0
                                    )
                                )
                            )
                        )
                    )
                )
            ),
            STRING,
            COMMENT
        )
    )
    var CONSTANT = Mode(
        className = "symbol",
        // begin: "@",
        // end: "${'$'}",
        // keywords = keywords("AppDataCommonDir AppDataDir AutoItExe AutoItPID AutoItVersion AutoItX64 COM_EventObj CommonFilesDir Compiled ComputerName ComSpec CPUArch CR CRLF DesktopCommonDir DesktopDepth DesktopDir DesktopHeight DesktopRefresh DesktopWidth DocumentsCommonDir error exitCode exitMethod extended FavoritesCommonDir FavoritesDir GUI_CtrlHandle GUI_CtrlId GUI_DragFile GUI_DragId GUI_DropId GUI_WinHandle HomeDrive HomePath HomeShare HotKeyPressed HOUR IPAddress1 IPAddress2 IPAddress3 IPAddress4 KBLayout LF LocalAppDataDir LogonDNSDomain LogonDomain LogonServer MDAY MIN MON MSEC MUILang MyDocumentsDir NumParams OSArch OSBuild OSLang OSServicePack OSType OSVersion ProgramFilesDir ProgramsCommonDir ProgramsDir ScriptDir ScriptFullPath ScriptLineNumber ScriptName SEC StartMenuCommonDir StartMenuDir StartupCommonDir StartupDir SW_DISABLE SW_ENABLE SW_HIDE SW_LOCK SW_MAXIMIZE SW_MINIMIZE SW_RESTORE SW_SHOW SW_SHOWDEFAULT SW_SHOWMAXIMIZED SW_SHOWMINIMIZED SW_SHOWMINNOACTIVE SW_SHOWNA SW_SHOWNOACTIVATE SW_SHOWNORMAL SW_UNLOCK SystemDir TAB TempDir TRAY_ID TrayIconFlashing TrayIconVisible UserName UserProfileDir WDAY WindowsDir WorkingDir YDAY YEAR"),
        // relevance: 5
        begin = "@[A-z0-9_]+"
    )
    var FUNCTION = Mode(
        className = "function",
        beginKeywords = keywords("Func"),
        end = "$",
        illegal = "\\$|\\[|%",
        contains = listOf(
            hljs.UNDERSCORE_TITLE_MODE,
            Mode(
                className = "params",
                begin = "\\(",
                end = "\\)",
                contains = listOf(
                    VARIABLE,
                    STRING,
                    NUMBER
                )
            )
        )
    )
    return Mode(
        case_insensitive = true,
        illegal =
            """\/\*""",
        keywords = listOf(
            keyword(
                className = "keyword",
                value = KEYWORDS
            ),
            keyword(
                className = "built_in",
                value = BUILT_IN
            ),
            keyword(
                className = "literal",
                value = LITERAL
            )
        ).flatten(),
        contains = listOf(
            COMMENT,
            VARIABLE,
            STRING,
            NUMBER,
            PREPROCESSOR,
            CONSTANT,
            FUNCTION
        )
    )
}
