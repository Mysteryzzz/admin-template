# mlearn
Admin template.


0. Config : 

 - ApplicationContext

    ![applicationContext](imgs/config/applicationContext.png)

 - Spring mvc
    
    ![spring mvc](imgs/config/spring-mvc.png)
    
1. class define

 - Package Name: Args[class]

 - Vo: ResultUtil
 
 - Config: AuthenticationInterceptor
 
 - Controller: AdminController, BookController, UserController, LoginController
 
 - Service(Implement): AdminService, BookService, OrderService, UserService
 
 - Entity: Admin, Book, Order, OrderItem, User
 
 - Mapper: AdminMapper, BookMapper, OrderItemMapper, OrderMapper, UserMapper
 
 - Util: CacheUtil, EncryptUtil, FileUtil, HexUtil, JsonUtil, QiNiuUtil
 
2. Detail design

 - login:
    
    No encryption frontend, Ajax send username & password directly.

    Backstage: Sha256(salt + password_from_front).equals(exist_password) -> update salt and password

 - BookCSM & UserCSM & OrderCSM

    - FontEnd send request using RESTFul like this:

        - GET: localhost/user check all users
        
        - POST: localhost/user add user

        - PUT: localhost/user/1 update user whose id equals 1

        - DELETE: localhost/user/1 delete user whose id equals 1

        - And so on.

    But one thing need to care: I do not use **token** to do the **Authentication** , and simplify the process with session instead.

    - BackEnd 

        - Controller will receive the form data and inject them to the entity located in the controller method.

        - Service will handle the whole transcations.




