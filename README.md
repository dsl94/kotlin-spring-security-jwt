# security-demo

This is Spring security Demo application using Kotlin and JWT
For testing purposes it uses H2 database, if you want to try it you have to register user 
with post call to
http://localhost:8090/api/register
with body (you can use other data)
{
	"username": "Nemanja",
	"email": "nemanjabosnjane@gmail.com",
	"fullName": "Nemanja Petrovic",
	"password": "test"
}

After that you have to login wit post call to
http://localhost:8090/api/login
{
	"username": "Nemanja",
	"password": "test"
}
If that passes you will get header Authorization with token which look like this:
Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJOZW1hbmphIiwiZXhwIjoxNTEwNDM2ODUwfQ.uSxlc8_L2h8MoUleQcIwgqGaoNDPMHI6GqluRgeMS37CafrgOgfGMx8o-rn85WpQcuf_AEwNuPvj49rdLRnkXg

Then you can test access to secure page, get call to:
http://localhost/api/secured
but you have to include Authorization token form login request
