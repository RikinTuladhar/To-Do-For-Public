# To Do Api 

This Api is created so that people can practice to perform some operations with apis.

## Api End-Point

```
https://to-do-for-public.onrender.com
```
---
## Usage
### Add : 
```
https://to-do-for-public.onrender.com 
```
With Http request of post body
```
{
	"name":"",
	"complete":false
}
```
---
### Get/ Read:
Use *fetch or axios* for fetching the data.
```
https://to-do-for-public.onrender.com 
```

---
### Delete
Put the id for deleting the to-do/data.
```
https://to-do-for-public.onrender.com/${id}
```

---
### Update to complete/incomplete
Provide *Id* of that to-do 
```
https://to-do-for-public.onrender.com/${id}
```
And also the value of true or false in http response body.

For true:
```
true 
```
For false:
```
false
```
---

