package com.github.qola.interfaceanddefaultmethod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;




/**
 * Created by Donny on 2017. 9. 18..
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
interface TestLifecycleLogger {

    Logger LOG = LogManager.getLogger(TestLifecycleLogger.class.getName());

    @BeforeAll
    default void beforeAllTests() {
        LOG.info("## Before all tests");
    }

    @AfterAll
    default void afterAllTests() {
        LOG.info("## After all tests");
    }

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("## [%s] 호출 전 ", testInfo.getDisplayName()));
    }

    @AfterEach
    default void afterEachTest(TestInfo testInfo) {
        LOG.info(() -> String.format("## [%s] 호출 후", testInfo.getDisplayName()));
    }
}
