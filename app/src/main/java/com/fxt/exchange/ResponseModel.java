package com.fxt.exchange;

import java.util.List;

public class ResponseModel {
    public List<Child> children;
    public Parent parent;
    public String levelToRoot;


    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public String getLevelToRoot() {
        return levelToRoot;
    }

    public void setLevelToRoot(String levelToRoot) {
        this.levelToRoot = levelToRoot;
    }



    public static class Child {
        public String id;
        public String name;
        public String email;
        public String refer_code;
        public String team_size;
        public String team_business;
        public String investment;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRefer_code() {
            return refer_code;
        }

        public void setRefer_code(String refer_code) {
            this.refer_code = refer_code;
        }

        public String getTeam_size() {
            return team_size;
        }

        public void setTeam_size(String team_size) {
            this.team_size = team_size;
        }

        public String getTeam_business() {
            return team_business;
        }

        public void setTeam_business(String team_business) {
            this.team_business = team_business;
        }

        public String getInvestment() {
            return investment;
        }

        public void setInvestment(String investment) {
            this.investment = investment;
        }
    }

        public static class Parent {
            public String id;
            public String name;
            public String refer_code;
            public String profile_photo_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRefer_code() {
                return refer_code;
            }

            public void setRefer_code(String refer_code) {
                this.refer_code = refer_code;
            }

            public String getProfile_photo_url() {
                return profile_photo_url;
            }

            public void setProfile_photo_url(String profile_photo_url) {
                this.profile_photo_url = profile_photo_url;
            }
        }


    }
