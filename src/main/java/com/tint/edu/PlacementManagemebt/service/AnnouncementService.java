package com.tint.edu.PlacementManagemebt.service;

import com.tint.edu.PlacementManagemebt.dto.AnnouncementReq;
import com.tint.edu.PlacementManagemebt.entity.Announcement;
import com.tint.edu.PlacementManagemebt.repository.AnnouncementRepo;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Service
public class AnnouncementService {

    private  static final Logger log= LoggerFactory.getLogger(AnnouncementService.class);
    @Value("${spring.mail.username}")
    private  String email;
    private final AnnouncementRepo announcementRepo;
    private  final JavaMailSender javaMailSender;

    public AnnouncementService(AnnouncementRepo announcementRepo, JavaMailSender javaMailSender) {
        this.announcementRepo = announcementRepo;
        this.javaMailSender = javaMailSender;
    }
    @Async("emailServiceAsync")
    public void saveAnnouncement(AnnouncementReq req) throws MessagingException {

        String info=req.getInfo();
        log.info("Thread is {}",Thread.currentThread().getName());
        Announcement announcement=new Announcement(info);
        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

        helper.setFrom(email);
        helper.setTo("pratham.kumar.it.2022@tint.edu.in");
        helper.setSubject("Placement Cell Announcement 📣");

        String htmlContent = """
        <html>
        <body style="font-family: Arial, sans-serif; background-color: #f4f6f8; padding: 20px;">

            <div style="max-width: 600px; margin: auto; background: white;
                        padding: 30px; border-radius: 10px;">

                <h2 style="color: #2c3e50;">
                    📣 Placement Cell Announcement
                </h2>

                <p style="font-size: 16px; color: #333;">
                    Hello,
                </p>

                <p style="font-size: 16px; color: #333;">
                    %s
                </p>

                <hr>

                <p style="font-size: 13px; color: #888;">
                    Regards,<br>
                    Placement Cell
                </p>

            </div>

        </body>
        </html>
        """.formatted(info);

        helper.setText(htmlContent, true);
        javaMailSender.send(message);
        announcementRepo.save(announcement);
    }
    public List<Announcement> showAllAnnouncement(){
        List<Announcement> allAnnouncement=announcementRepo.findAll();
        Queue<Announcement> pq=new PriorityQueue<>((a,b)->b.getPublishTime().compareTo(a.getPublishTime()));
        pq.addAll(allAnnouncement);
        List<Announcement> sortedList = new ArrayList<>();

        while (!pq.isEmpty()) {
            sortedList.add(pq.poll()); // always gives latest first
        }
        return sortedList;
    }
}
