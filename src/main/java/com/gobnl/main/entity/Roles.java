package com.gobnl.main.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "roles")
public class Roles {
    @Id
    private String roleId;
    private String name;
    private String desc;

    public Roles() {}
    public Roles(String roleId, String name, String desc) {
        this.roleId = roleId;
        this.name = name;
        this.desc = desc;
    }
    public Roles(String name) {
        this.name = name;
    }

    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "roleId='" + roleId + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
