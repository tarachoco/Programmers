@echo off
chcp 65001 >nul
REM 스크립트 시작
setlocal enabledelayedexpansion

REM 현재 디렉터리를 저장합니다.
set CURRENT_DIR=%cd%

REM Git 저장소 디렉터리로 이동합니다.
cd /d "D:\STUDY\Programmers"

REM Git 상태를 확인하고 변경된 파일 목록을 얻습니다.
for /f "tokens=2* delims= " %%i in ('git status --porcelain') do (
    set FIRST_FILE=%%i
    goto :found
)
:found

REM 변경된 파일이 있는 경우 추가합니다.
if defined FIRST_FILE (
    REM 첫 번째 파일을 추가합니다.
    echo git add "!FIRST_FILE!"
    git add "!FIRST_FILE!"

    REM 커밋 메시지를 설정합니다.
    set COMMIT_MSG=커밋 메시지: %date% %time%

    REM 커밋을 수행합니다.
    echo git commit -m "!COMMIT_MSG!"
    git commit -m "!COMMIT_MSG!"

    REM 원격 저장소에 푸시합니다.
    echo git push origin master
    git push origin master
) else (
    echo 변경된 파일이 없습니다.
)

REM 원래 디렉터리로 돌아갑니다.
cd /d %CURRENT_DIR%

REM 스크립트 종료
endlocal
@echo on