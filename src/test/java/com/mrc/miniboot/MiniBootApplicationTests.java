package com.mrc.miniboot;

import com.mrc.miniboot.controller.LoginController;
import com.mrc.miniboot.entity.Item.Item;
import com.mrc.miniboot.repo.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MiniBootApplicationTests {
    @Resource
    private ItemRepository itemRepository;

    @Test
    public void tt1() {
        HashMap<Integer, String[]> map = new HashMap<>();
        String[] s1 = {"车体配件1", "车体配件2", "车体配件3",
                "车体配件4", "车体配件5", "车体配件6", "车体配件7",};
        String[] s2 = {"转向架配件1", "转向架配件2", "转向架配件3",
                "转向架配件4", "转向架配件5", "转向架配件6", "转向架配件7",};
        String[] s3 = {"货总配件1", "货总配件2", "货总配件3",
                "货总配件4", "货总配件5", "货总配件6", "货总配件7",};
        String[] s4 = {"轮轴配件1", "轮轴配件2", "轮轴配件3",
                "轮轴配件4", "轮轴配件5", "轮轴配件6", "轮轴配件7",};
        String[] s5 = {"焊丝1", "焊丝2", "焊丝3",
                "焊丝4", "焊丝5", "焊丝6", "焊丝7",};
        map.put(1001, s1);
        map.put(1002, s2);
        map.put(1003, s3);
        map.put(2001, s4);
        map.put(2002, s5);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" );
            for (String s : (String[]) entry.getValue()) {
                Item item = new Item().setWarehouseId((Integer) entry.getKey()).setName(s).setQualifiedNum(0).setUnqualifiedNum(0).setScrappedNum(0);
                itemRepository.save(item);
            }
        }
    }

    @Test
    public void tt2() {
        List<Item> items = itemRepository.findByWarehouseId(1001);
        for (Item item : items) {
            System.out.println(item.getName());
        }
    }
}
