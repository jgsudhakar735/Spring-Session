package com.jgsudhakar.spring.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastIndexedSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.config.HazzleCastConfig
 * @Date : 11/10/2020
 */
@Configuration
@EnableHazelcastHttpSession(maxInactiveIntervalInSeconds = 5)
public class HazzleCastConfig {

    @Bean
    @Qualifier("hz")
    public HazelcastInstance hazelcastInstance () {
        Config config = new Config();
        config.setInstanceName("jgsudhakar735");
        NetworkConfig networkConfig = new NetworkConfig();
        networkConfig.setPort(9898);
        config.setNetworkConfig(networkConfig);
        MapAttributeConfig attributeConfig = new MapAttributeConfig()
                .setName(HazelcastIndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                .setExtractor(PrincipalNameExtractor.class.getName());
        config.getMapConfig(HazelcastIndexedSessionRepository.DEFAULT_SESSION_MAP_NAME)
                .addMapAttributeConfig(attributeConfig).addMapIndexConfig(
                new MapIndexConfig(HazelcastIndexedSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));
        return Hazelcast.newHazelcastInstance(config);
    }
}
