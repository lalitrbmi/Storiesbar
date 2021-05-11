package com.lalit.storiesbar.model;

public class Data {
    private Stories[] stories;

    private String user_id;

    private String store_name;

    private String id;

    private String is_online;

    private String store_image;

    public Stories[] getStories ()
    {
        return stories;
    }

    public void setStories (Stories[] stories)
    {
        this.stories = stories;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getStore_name ()
    {
        return store_name;
    }

    public void setStore_name (String store_name)
    {
        this.store_name = store_name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getIs_online ()
    {
        return is_online;
    }

    public void setIs_online (String is_online)
    {
        this.is_online = is_online;
    }

    public String getStore_image ()
    {
        return store_image;
    }

    public void setStore_image (String store_image)
    {
        this.store_image = store_image;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [stories = "+stories+", user_id = "+user_id+", store_name = "+store_name+", id = "+id+", is_online = "+is_online+", store_image = "+store_image+"]";
    }
}
