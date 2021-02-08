package com.illuminator.response;

import com.illuminator.repository.goalreaches.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalReachesRepositoryHolder {

    @Autowired
    private AdvEngineGoalReachesRepo advEngineRepo;

    @Autowired
    private ReferralSourceGoalReachesRepo referralSourceRepo;

    @Autowired
    private SearchPhraseGoalReachesRepo searchPhraseRepo;

    @Autowired
    private SearchEngineGoalReachesRepo searchEngineRepo;

    @Autowired
    private SocialNetworkGoalReachesRepo socialNetworkRepo;

    @Autowired
    private TrafficSourceGoalReachesRepo trafficSourceRepo;


    public AdvEngineGoalReachesRepo getAdvEngineRepo() {
        return advEngineRepo;
    }

    public ReferralSourceGoalReachesRepo getReferralSourceRepo() {
        return referralSourceRepo;
    }

    public SearchPhraseGoalReachesRepo getSearchPhraseRepo() {
        return searchPhraseRepo;
    }

    public SearchEngineGoalReachesRepo getSearchEngineRepo() {
        return searchEngineRepo;
    }

    public SocialNetworkGoalReachesRepo getSocialNetworkRepo() {
        return socialNetworkRepo;
    }

    public TrafficSourceGoalReachesRepo getTrafficSourceRepo() {
        return trafficSourceRepo;
    }

}
