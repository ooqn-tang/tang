import jwt_decode from "jwt-decode"

export function setToken(data) {
    let tokenData = jwt_decode(data);
    localStorage.setItem("jwt",data);
    localStorage.setItem("author",JSON.stringify(tokenData.author));
}

export function removeToken(store) {
    localStorage.removeItem("jwt");
    localStorage.removeItem("author");
    store.state.username = "";
}
