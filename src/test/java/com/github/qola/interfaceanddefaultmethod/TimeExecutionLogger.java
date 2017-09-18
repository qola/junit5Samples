package com.github.qola.interfaceanddefaultmethod;

import com.github.qola.extension.TimingExtension;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Created by Donny on 2017. 9. 18..
 */
@Tag("timed")
@ExtendWith(TimingExtension.class)
interface TimeExecutionLogger {
}
