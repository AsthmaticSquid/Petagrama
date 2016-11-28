package com.calamarasmtic.petagram.restApi;

/**
 * Created by Calamar Asmàtic on 27/11/2016.
 */

public final class ConstantesRestApi {

    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4178937654.143d149.92824fb8606c46ff804292fbb07af1f2";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/{user-id}/media/recent/?access_token=ACCESS-TOKEN
    public static final String KEY_GET_RECENT_MEDIA_OTHER_USER_1 = "users/";
    public static final String KEY_GET_RECENT_MEDIA_OTHER_USER_2 = "/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA_OTHER_USER_3 = KEY_GET_RECENT_MEDIA_OTHER_USER_2 + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    //https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN
    public static final String KEY_GET_USER_ID_BY_USERNAME_1 = "users/search?q=";
    public static final String KEY_GET_USER_ID_BY_USERNAME_2 = "&access_token=";
    public static final String KEY_GET_USER_ID_BY_USERNAME_3 = KEY_GET_USER_ID_BY_USERNAME_2 + ACCESS_TOKEN;


}
