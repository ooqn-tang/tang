import jwt_decode from "jwt-decode"



export function setToken(data) {
    let tokenData = jwt_decode(data)
    localStorage.setItem("jwt",data)
    localStorage.setItem("authorData",JSON.stringify(tokenData.author))
}

export function removeToken() {
    let tokenData = jwt_decode(data)
    localStorage.removeItem("jwt",data)
    localStorage.removeItem("authorData",JSON.stringify(tokenData.author))
    this.$store.state.username = ""
    this.$store.state.roles = []
    window.location.href = "/"
}
