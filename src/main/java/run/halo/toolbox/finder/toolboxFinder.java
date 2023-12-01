package run.halo.toolbox.finder;

import run.halo.toolbox.Toolbox;

/**
 * A finder for {@link Toolbox}
 */
public interface toolboxFinder {
    /**
     * 获取点赞
     * @param name 唯一标识
     * @param groupBy 分组 自定义
     * @return 点赞数
     */
    Integer getVote(String name,Integer groupBy);
}
