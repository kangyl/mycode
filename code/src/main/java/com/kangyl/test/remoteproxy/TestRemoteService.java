package com.kangyl.test.remoteproxy;

import java.util.List;

/**
 * @author : kangyl(460720197@qq.com)
 * @date: 2020/5/19
 */
@RemoteService("com.kangyl.abc")
public interface TestRemoteService {

    List<String> queryDatas();
}
