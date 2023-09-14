package com.entities;

public class User {
    private String id, name, email, mob;

    private User(String id, String name, String email, String mob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mob = mob;
    }

    public static class UserBuilder{
        private String id, name, email, mob;
        public UserBuilder addId(String id){
            this.id = id;
            return this;
        }
        public UserBuilder addName(String id){
            this.name = id;
            return this;
        }
        public UserBuilder addEmail(String id){
            this.email = id;
            return this;
        }
        public UserBuilder addMob(String id){
            this.mob = id;
            return this;
        }

        public User get(){
            return new User(id, name, email, mob);
        }
    }
}
