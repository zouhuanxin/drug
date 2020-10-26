package com.example.drug.handler;

import com.example.drug.entity.Remind;
import com.example.drug.mapper.DrugMapper;
import com.example.drug.util.EmailUtil;
import com.example.drug.util.SMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 定时任务每分钟一次
 * 检查是否有需要发送的任务
 */
@Component
@EnableScheduling
public class TimingTask {
    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private SMSUtil smsUtil;
    @Autowired
    private EmailUtil emailUtil;

    //或直接指定时间间隔
    @Scheduled(fixedRate = 60000)
    private void configureTasks() {
        List<Remind> reminds = drugMapper.ByStatusRemindDatas(0);
        //发送短信
        for (int i = 0; i < reminds.size(); i++) {
            long dif = subtractionTime(reminds.get(i).getDrugtaketime());
            if (dif >= 0 && dif <= 5){
                if (reminds.get(i).getEmail() != null){
                    drugMapper.updateRemindEmailStatus(1,reminds.get(i).getId());
                    emailUtil.sendSimpleMailMessge(reminds.get(i).getEmail(), "您有服药提醒",
                            "您好！您有新的服药提醒请注意服药并点击链接确认服药！http://123.57.45.169:8084/Sign.html?id="+reminds.get(i).getId());
                }
            }
        }
    }

    /**
     * 时间减法
     */
    private long subtractionTime(String time2) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long diff = 0;
        try {
            Date date2 = df.parse(time2);
            //从对象中拿到时间
            long currentTime = System.currentTimeMillis();
            long createTime = date2.getTime();
            diff = (currentTime - createTime) / 1000 / 60;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return diff;
    }

}
