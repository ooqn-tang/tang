import jwt_decode from "jwt-decode"


export function setToken(data) {
    let tokenData = jwt_decode(data)
    localStorage.setItem("token",data)
    localStorage.setItem("author",JSON.stringify(tokenData.author))
}
