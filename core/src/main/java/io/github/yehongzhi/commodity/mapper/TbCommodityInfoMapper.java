package io.github.yehongzhi.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.yehongzhi.model.TbCommodityInfo;
import org.springframework.stereotype.Repository;

@Repository("tbCommodityInfoMapper")
public interface TbCommodityInfoMapper extends BaseMapper<TbCommodityInfo> {

    void updateByPK(TbCommodityInfo tbCommodityInfo);
}
