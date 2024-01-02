import { defineStore } from 'pinia';

export const useAuthorStore = defineStore('author', {
    state: () => {
        return {
            author: {},
            roles: []
        }
    },
    actions: {
        setAuthor(author) {
            this.author = author;
        },
        setRoles(roles) {
            if (roles != null) {
                for (let item of roles) {
                    this.roles.push(item.roleValue)
                }
            }
        },
        logout() {
            this.author = {};
            this.roles = [];
            localStorage.removeItem("jwt");
            localStorage.removeItem("author");
            localStorage.removeItem("roles")
        }
    },
})
