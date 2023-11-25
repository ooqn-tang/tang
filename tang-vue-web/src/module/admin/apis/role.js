import request from "@common/request";

export function loadRolesApi() {
    return request({
        url: `/api/admin/role`,
        method: "GET"
    });
}

/**
 * updateAuthorRole
 * @param {*} authorId 
 * @param {*} roles 
 * @returns 
 */
export function updateAuthorRoleApi(authorId, roles) {
    return request({
        url: `/api/admin/role/author/${authorId}`,
        method: "PUT",
        data: roles
    });
}