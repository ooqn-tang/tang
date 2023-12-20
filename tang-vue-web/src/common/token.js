export function setToken(data) {
    localStorage.setItem("jwt", data);
}

export function removeToken() {
    localStorage.removeItem("jwt");
}
