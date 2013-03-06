@echo off
echo [Info] crypt DB password.
echo [Info] usage:cryptPassword your_password.

java -cp hibernate/lib/druid-0.2.10.jar com.alibaba.druid.filter.config.ConfigTools %1
pause