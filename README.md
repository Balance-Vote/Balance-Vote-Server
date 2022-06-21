# Balance-Vote-Server

> ## Balance-Vote-Server는 BalanceVote App의 API 서버입니다.
> ### 구현 기능
> 
> | Feature | Stack | |
> |---------|-------|-|
> | Server | Spring Boot |<img src="https://user-images.githubusercontent.com/22022776/174630380-998da0b9-4e5a-4b7d-baa4-ac930632fe39.png" height="40px">|
> | RDBS | MySql |<img src="https://user-images.githubusercontent.com/22022776/174739483-c6024a78-8da6-45b4-89ab-c2c7ee4f5222.png" height="40px">|
> | API Doc | Swagger-UI |<img src="https://user-images.githubusercontent.com/22022776/174738161-6ff5c992-00a8-4b8d-a28c-a64be7e2548d.png" height="40px">|
> | CI | Github Actions |<img src="https://user-images.githubusercontent.com/22022776/174737872-343461c0-a5ec-4164-bd68-5639bb5ca2fe.png" height="40px">|
> | CD | AWS CodeDeploy |<img src="https://user-images.githubusercontent.com/22022776/174738914-fc290e74-82ee-4d4d-a9e5-e656e1bbec8d.png" height="40px">|
> | Deploy | AWS EC2 | <img src="https://user-images.githubusercontent.com/22022776/174738914-fc290e74-82ee-4d4d-a9e5-e656e1bbec8d.png" height="40px">|
> -------------------------------------
> ### 역할 분담(R & R)
>  | 담당자 | 담당 기능 | |
>  |-------|-----------|-|
>  | 최준만 | SpringBoot 초기 세팅 및 MVC 구성 | :heavy_check_mark: |
>  |       | User, Comment API | :heavy_check_mark: |
>  |       | AWS EC2 구성 | :heavy_check_mark: |
>  |       | AWS CodeDeploy 배포 자동화 구현(CD) | :heavy_check_mark: |
>  |       | RDBS 테이블 설계 및 구현 | :heavy_check_mark: |
>  | 이동건 | Vote Post API | :heavy_check_mark: |
>  |       | Swagger-ui API 명세사이트 구성 | :heavy_check_mark: |
>  |       | Github Actions 지속적 통합 과정 구현(CI) | :heavy_check_mark: |
>  |       | RDBS 테이블 설계 및 구현 | :heavy_check_mark: |
>--------------------------------------
> ### 기능 설명
> - API는 유저, 투표 게시물, 댓글 및 대댓글 CRUD로 구성
>--------------------------------------
> - API 명세는 Swagger-UI를 통해 구성
> 
>  | <sub> Swagger UI 구현 <sub> | <sub> API 명세 및 테스트 <sub> |
>  |----------------------------|-------------------------------|
>  | ![swagger-ui](https://user-images.githubusercontent.com/22022776/174628458-7834d296-7981-4ec6-a204-0787dbc4eb14.png) | ![swagger-ui](https://user-images.githubusercontent.com/22022776/174628957-66d6ee3e-5c4b-4d3a-8fa3-97344e3bc39d.png) |
>---------------------------------------
> - 자동 배포(Github Actions & AWS)
>
>  | <sub> CD/CI 구성 및 동작 <sub> |
>  |----------------------------|
> |![image](https://user-images.githubusercontent.com/22022776/174751746-2eca574c-8c8f-466b-a6e2-fb2893d2be6a.png)|
