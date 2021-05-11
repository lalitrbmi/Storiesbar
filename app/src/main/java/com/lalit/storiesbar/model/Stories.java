package com.lalit.storiesbar.model;

public class Stories {
    private String store_id;

    private String image;

    private String start_time;

    private String updated_at;

    private String user_id;

    private String vendor_id;

    private String end_time;

    private String caption;

    private String created_at;

    private String id;

    private String type;

    public String getStore_id ()
    {
        return store_id;
    }

    public void setStore_id (String store_id)
    {
        this.store_id = store_id;
    }

    public String getImage ()
    {
        return image;
    }

    public void setImage (String image)
    {
        this.image = image;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public String getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (String updated_at)
    {
        this.updated_at = updated_at;
    }

    public String getUser_id ()
    {
        return user_id;
    }

    public void setUser_id (String user_id)
    {
        this.user_id = user_id;
    }

    public String getVendor_id ()
    {
        return vendor_id;
    }

    public void setVendor_id (String vendor_id)
    {
        this.vendor_id = vendor_id;
    }

    public String getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (String end_time)
    {
        this.end_time = end_time;
    }

    public String getCaption ()
    {
        return caption;
    }

    public void setCaption (String caption)
    {
        this.caption = caption;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getType ()
    {
        return type;
    }

    public void setType (String type)
    {
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [store_id = "+store_id+", image = "+image+", start_time = "+start_time+", updated_at = "+updated_at+", user_id = "+user_id+", vendor_id = "+vendor_id+", end_time = "+end_time+", caption = "+caption+", created_at = "+created_at+", id = "+id+", type = "+type+"]";
    }
}
