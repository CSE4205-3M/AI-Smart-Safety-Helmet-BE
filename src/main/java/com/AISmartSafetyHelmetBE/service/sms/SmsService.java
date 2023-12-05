package com.AISmartSafetyHelmetBE.service.sms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoMessageNotReceivedException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SmsService {
    public void sendSMS(String content) {
        DefaultMessageService messageService =  NurigoApp.INSTANCE.initialize("NCSNTSA3EZL9HLEV", "1KLQIOSIMTBDFDCSQWDYFWB1VQNDBHW6", "https://api.coolsms.co.kr");
        Message message = new Message();
        message.setFrom("01049062475");
        message.setTo("01049062475");
        message.setText(content);

        try {
            // send 메소드로 ArrayList<Message> 객체를 넣어도 동작합니다!
            messageService.send(message);
        } catch (NurigoMessageNotReceivedException exception) {
            // 발송에 실패한 메시지 목록을 확인할 수 있습니다!
            System.out.println(exception.getFailedMessageList());
            System.out.println(exception.getMessage());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
