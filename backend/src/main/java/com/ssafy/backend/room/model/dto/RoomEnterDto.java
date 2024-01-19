package com.ssafy.backend.room.model.dto;

import java.util.HashMap;

public class RoomEnterDto {
    private String sessionName;
    private String videoCodec;

    public RoomEnterDto(String sessionName, String videoCodec) {
        this.sessionName = sessionName;
        this.videoCodec = videoCodec;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public void setVideoCodec(String videoCodec) {
        this.videoCodec = videoCodec;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getVideoCodec() {
        return videoCodec;
    }

    public HashMap<String,String> toSessionPropertyJson(){
        HashMap<String,String> SessionPropertyJson = new HashMap<>();
        SessionPropertyJson.put("customSessionId",this.sessionName);
        SessionPropertyJson.put("forcedVideoCodec",this.videoCodec);
        return SessionPropertyJson;
    }
}
