package net.runelite.launcher.utils;

import net.runelite.launcher.OpenOSRSSplashScreen;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;

public class GitHubUtils
{
	private static final GitHub GITHUB;

	static
	{
		try
		{
			GITHUB = GitHub.connectAnonymously();
		}
		catch (IOException e)
		{
			OpenOSRSSplashScreen.init(null);
			OpenOSRSSplashScreen.setError("Error connecting to GitHub!", "We couldn't connect to the GitHub " +
					"repository.");
			throw new RuntimeException(e);
		}
	}

	public static GHRepository getRepo()
	{
		try
		{
			return GITHUB.getRepository("unethicalite/unethicalite-hosting");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
	}
}
