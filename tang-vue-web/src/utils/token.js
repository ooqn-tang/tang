import jwt_decode from "jwt-decode"



export function setToken(data) {
    let tokenData = jwt_decode(data)
    localStorage.setItem("jwt",data)
    localStorage.setItem("authorData",JSON.stringify(tokenData.author))
}

export function removeToken(store) {
    localStorage.removeItem("jwt")
    localStorage.removeItem("authorData")
    store.state.username = ""
    store.state.roles = []
}
