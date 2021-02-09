package com.illuminator.response;

import com.illuminator.entity.source.*;
import com.illuminator.repository.source.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SourceRepositoryHolder {

    @Autowired
    private AdvEngineRepository advEngineRepository;

    @Autowired
    private SearchEngineRepository searchEngineRepository;

    @Autowired
    private ReferralSourceRepository referralSourceRepository;

    @Autowired
    private SearchPhraseRepository searchPhraseRepository;

    @Autowired
    private SocialNetworkRepository socialNetworkRepository;

    @Autowired
    private TrafficSourceRepository trafficSourceRepository;

    private Map<Class<? extends SourceSuperclass>, CrudRepository> sourceToRepositoryMap;

    public SourceRepositoryHolder() {
        initializeSourceMap();
    }

    private void initializeSourceMap() {
        sourceToRepositoryMap.put(AdvEngine.class, advEngineRepository);
        sourceToRepositoryMap.put(SearchEngine.class, searchEngineRepository);
        sourceToRepositoryMap.put(ReferralSource.class, referralSourceRepository);
        sourceToRepositoryMap.put(SearchPhrase.class, searchPhraseRepository);
        sourceToRepositoryMap.put(SocialNetwork.class, socialNetworkRepository);
        sourceToRepositoryMap.put(TrafficSource.class, trafficSourceRepository);
    }

    public CrudRepository getSourceRepository(Class<? extends SourceSuperclass> source) {
        return sourceToRepositoryMap.get(source);
    }

    public AdvEngineRepository getAdvEngineRepository() {
        return advEngineRepository;
    }

    public SearchEngineRepository getSearchEngineRepository() {
        return searchEngineRepository;
    }

    public ReferralSourceRepository getReferralSourceRepository() {
        return referralSourceRepository;
    }

    public SearchPhraseRepository getSearchPhraseRepository() {
        return searchPhraseRepository;
    }

    public SocialNetworkRepository getSocialNetworkRepository() {
        return socialNetworkRepository;
    }

    public TrafficSourceRepository getTrafficSourceRepository() {
        return trafficSourceRepository;
    }
}
