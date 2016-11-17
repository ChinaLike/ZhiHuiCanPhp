package net.xprogrammer.xwechat;

import javax.servlet.http.HttpServletRequest;

import org.sword.wechat4j.WechatSupport;

public class XWeChatSupport extends WechatSupport {

	public XWeChatSupport(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected void onText() {
		String content = super.wechatRequest.getContent().trim();
		if (content.equals("1")) {
			responseText("你好，hello world!<a href=\"http://www.baidu.com\">切问度娘，这是链接</a>");
		} else if (content.equals("2")) {
			responseText("你好，hello world!<a href=\"http://www.pactera.com\">到东家吃饭</a>");
		} else if (content.equals("kevin")) {
			responseText("这小子很帅");
		} else {
			responseText("你好，你的输入为 " + content + "\n" + "请按照如下操作输入:\n" + "1: 度娘\n" + "2: 东家\n");
		}
	}

	@Override
	protected void onImage() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onVoice() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onVideo() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onShortVideo() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLink() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onUnknown() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void click() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void subscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void unSubscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void scan() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void location() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void view() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void templateMsgCallback() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void scanCodePush() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void scanCodeWaitMsg() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void picSysPhoto() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void picPhotoOrAlbum() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void picWeixin() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void locationSelect() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void kfCreateSession() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void kfCloseSession() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void kfSwitchSession() {
		// TODO Auto-generated method stub

	}

}
