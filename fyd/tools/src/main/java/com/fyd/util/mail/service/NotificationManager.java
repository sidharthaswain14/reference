package com.fyd.util.mail.service;

import com.fyd.util.mail.beans.MailMessage;

public interface NotificationManager {
	public void send(MailMessage mailMessage);
}
