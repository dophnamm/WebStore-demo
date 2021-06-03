package tag;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyTag extends SimpleTagSupport {
	private String uri;
	private int offset;
	private long count;
	private int steps;
	private String previous = "Previous";
	private String next = "Next";

	private Writer getWriter() {
		JspWriter out = getJspContext().getOut();
		return out;
	}

	@Override
	public void doTag() throws JspException, IOException {
		Writer out = getWriter();
		try {
			out.write("<nav>");
			out.write("<ul class=\"pagination\">");

			if (offset < steps) {
				out.write(constructLink(1, previous, "disabled", true));
			} else {
				out.write(constructLink(offset - steps, previous, null, false));
			}

			for (int itr = 0; itr < count; itr += steps) {
				if (offset == itr) {
					out.write(constructLink((itr / steps + 1) - 1 * steps, String.valueOf(itr / steps + 1), "active",
							true));
				} else {
					out.write(constructLink(itr / steps * steps, String.valueOf(itr / steps + 1), null, false));
				}
			}

			if (offset + steps >= count) {
				out.write(constructLink(offset + steps, next, "disabled", true));
			} else {
				out.write(constructLink(offset + steps, next, null, false));
			}

			out.write("</ul>");
			out.write("</nav>");
		} catch (java.io.IOException ex) {
			throw new JspException("Error in Paginator tag", ex);
		}
	}

	private String constructLink(int page, String text, String className, boolean disabled) {
		StringBuilder link = new StringBuilder("<li");
		if (className != null) {
			link.append(" class=\"");
			link.append(className);
			link.append("\"");
		}
		if (disabled) {
			link.append(">").append("<a href=\"#\">" + text + "</a></li>");
		} else {
			link.append(">").append("<a href=\"" + uri + "?offset=" + page + "\">" + text + "</a></li>");
		}
		return link.toString();
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public String getPrevious() {
		return previous;
	}

	public void setPrevious(String previous) {
		this.previous = previous;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}
