package com.illuminator.response;

import com.illuminator.repository.source.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
