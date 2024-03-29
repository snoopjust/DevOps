/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Gradle.Test.Ahmad;

import java.util.ArrayList;
import java.util.List;

import com.indvd00m.ascii.render.Region;
import com.indvd00m.ascii.render.Render;
import com.indvd00m.ascii.render.api.ICanvas;
import com.indvd00m.ascii.render.api.IContextBuilder;
import com.indvd00m.ascii.render.api.IRender;
import com.indvd00m.ascii.render.elements.PseudoText;
import com.indvd00m.ascii.render.elements.Rectangle;
import com.indvd00m.ascii.render.elements.plot.Axis;
import com.indvd00m.ascii.render.elements.plot.AxisLabels;
import com.indvd00m.ascii.render.elements.plot.Plot;
import com.indvd00m.ascii.render.elements.plot.api.IPlotPoint;
import com.indvd00m.ascii.render.elements.plot.misc.PlotPoint;

public class App {
    public String getGreeting() {
        return "Hello World! Ich bin Ahmad";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
        
        //ASCII RENDER BEISPIEL
        IRender render = new Render();
		IContextBuilder builder = render.newBuilder();
		builder.width(120).height(20);
		builder.element(new PseudoText("PR Ahmad"));

		ICanvas canvas = render.render(builder.build());
		String s = canvas.getText();
		System.out.println(s);


        // Plot Beispiel
        List<IPlotPoint> points = new ArrayList<IPlotPoint>();
		for (int degree = 0; degree <= 360; degree++) {
			if (degree > 75 && degree < 105) {
				continue;
			}
			if (degree > 255 && degree < 285) {
				continue;
			}
			double val = Math.tan(Math.toRadians(degree));
			IPlotPoint plotPoint = new PlotPoint(degree, val);
			points.add(plotPoint);
		}
		IRender render_plot = new Render();
		IContextBuilder builder_plot = render_plot.newBuilder();
		builder_plot.width(80).height(20);
		builder_plot.element(new Rectangle(0, 0, 80, 20));
		builder_plot.layer(new Region(1, 1, 78, 18));
		builder_plot.element(new Axis(points, new Region(0, 0, 78, 18)));
		builder_plot.element(new AxisLabels(points, new Region(0, 0, 78, 18)));
		builder_plot.element(new Plot(points, new Region(0, 0, 78, 18)));
		ICanvas canvas_plot = render_plot.render(builder_plot.build());
		String plot = canvas_plot.getText();
		System.out.println(plot);
    }
}
