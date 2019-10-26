package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ICollectionService {
    void Add(int user_id,int be_collected_id);
    void Delete(int user_id,int be_deleted_id);
    ArrayList QueryCollection(int user_id,int start_from,int limitation);
    Integer IfCollecting(int user_id,int message_id);
    Integer GetCollectionNum(int user_id);
}
