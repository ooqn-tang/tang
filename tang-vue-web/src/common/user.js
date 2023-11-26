import { defineStore } from 'pinia';

export const useAuthorStore = defineStore('author', {
    state: () => {
        return {
            username:'',
            author:{},
            isAdmin:false,
            roles:[]
        }
    },
    actions: {
        setAuthor(author) {
            this.author = author;
            this.username = author.username;
        },
        setRoles(roles){
            if(roles != null){
                for(let item of roles){
                    if(item.roleValue == 'ROLE_ADMIN'){
                        this.isAdmin = true
                    }
                    this.roles.push(item.roleValue)
                }
            }
        },
        logout(){
            this.username = '';
            this.author = {};
            this.isAdmin = false;
            this.roles = [];
            localStorage.removeItem("jwt");
            localStorage.removeItem("author");
            localStorage.removeItem("roles")
        }
    },
})
