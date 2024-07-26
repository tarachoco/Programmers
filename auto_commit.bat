@echo off
REM 스크립트 시작
setlocal

REM 현재 디렉터리를 저장합니다.
set CURRENT_DIR=%cd%

REM Git 저장소 디렉터리로 이동합니다.
cd /d "D:\STUDY\Programmers"

REM Git 상태를 확인합니다.
git status

REM 모든 변경 사항을 추가합니다.
git add .

REM 커밋 메시지를 설정합니다.
set COMMIT_MSG="자동 커밋 메시지: %date% %time%"

REM 커밋을 수행합니다.
git commit -m %COMMIT_MSG%

REM 원격 저장소에 푸시합니다.
git push origin main

REM 원래 디렉터리로 돌아갑니다.
cd /d %CURRENT_DIR%

REM 스크립트 종료
endlocal
@echo on