package net.xprogrammer.xwechat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class XWeChatController {

	@RequestMapping(value = "/xwechat", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public String xWechatGet(HttpServletRequest request) {
		XWeChatSupport weichat = new XWeChatSupport(request);
		String result = weichat.execute();
		return result;
	}

	@RequestMapping(value = "/xwechat", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	public String xWechatPost(HttpServletRequest request) {
		XWeChatSupport weichat = new XWeChatSupport(request);
		String result = weichat.execute();
		return result;
	}
}
