# ChenXiBackend
# 使用SpringBoot  全家桶快速打起来的Android App 后台，使用传说中的Json  web token 做为认证方式，欢迎交流学习

##模拟注册
##在bash  下使用 curl
##curl -H "Content-Type:application/json" -X POST -d '{"password":"aaa","phone":"safsad"}' http://127.0.0.1:8080/user/register

##模拟登陆 
### curl -i -X POST -H "Content-Type:application/json" -d '{"password":"aaa","phone":"aaaaaaa"}' http://127.0.0.1:8080/user/login