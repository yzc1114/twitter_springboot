package com.yzchnb.twitter.service;

import java.util.ArrayList;

public interface ISearchService {
    ArrayList GetTwitterResults(String search_key,int start_from,int limitation);
    ArrayList GetUserResults(String search_key,int start_from,int limitation);
    ArrayList GetTopicResults(String search_key,int start_from,int limitation);
}
