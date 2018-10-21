package demili53.game.lolhaja.Access.domain;

import javax.servlet.http.HttpServletRequest;

public class Access {
	private String url;
	private String path;
	private String param;
	public Access(HttpServletRequest request) {
		super();
		url = request.getScheme()+"://"+request.getServerName();
		path = request.getRequestURI();
		param = request.getQueryString();
	}
	@Override
	public String toString() {
		return "Access [url=" + url + ", path=" + path + ", param=" + param + "]";
	}
	
//getScheme()	http	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getServerName()	192.168.1.2	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getServerPort()	80	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getContextPath()	/TestApp	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getServletPath()	/actions/login.action	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getPathInfo()	null	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getQueryString()	user=rob&pass=kittens	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
//getRequestURI()	/TestApp/actions/login.action	http://192.168.1.2/TestApp/actions/login.action?user=rob&pass=kittens
	
}
