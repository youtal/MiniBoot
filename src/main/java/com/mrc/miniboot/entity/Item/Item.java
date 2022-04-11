package com.mrc.miniboot.entity.Item;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Data
@Table(name = "item")
@Entity
@Accessors(chain = true)
public class Item {

    //物品id
    @Column(name = "id",nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //物品名称
    @Column(name = "name",nullable = false)
    private String name;

    //所属仓库id
    /**
     * 仓库id设置如下：
     * 车体配件仓库： 1001
     * 转向架配件仓库： 1002
     * 货总装配件仓库： 1003
     * 焊丝轮轴配件仓库： 2001
     * 紧固件仓库：2002
     * 机电仓库：2003
     * 油漆仓库：2004
     * 板材库： 3001
     * 型材库： 3002
     * 小型钢材库： 3003
     * */
    @Column(name = "warehouse_id",nullable = false)
    private Integer warehouseId;

    //合格品数量
    @Column(name = "qualified_num",nullable = false)
    private Integer qualifiedNum;

    //待检品数量
    @Column(name = "unqualified_num",nullable = false)
    private Integer unqualifiedNum;

    //报废品数量
    @Column(name = "scrapped_num",nullable = false)
    private Integer scrappedNum;

    //直接移入待验区
    public void moveToUnqualified(Integer num){
        this.unqualifiedNum += num;
    }

    //直接移入合格区
    public void moveToQualified(Integer num){
        this.qualifiedNum += num;
    }

    //直接移入报废区
    public void moveToScrapped(Integer num){
        this.scrappedNum += num;
    }

    //待验区移入合格区
    public void moveToQualifiedFromUnqualified(Integer num){
        this.unqualifiedNum -= num;
        this.qualifiedNum += num;
    }

}
