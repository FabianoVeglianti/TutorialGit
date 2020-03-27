package Prova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class ezechiele {

	public static void main(String[] args) throws IOException {
		testSomeMethod();
	}	
	
	public static void testSomeMethod() throws IOException
    {
		// Init connection
        GitHubClient client = new GitHubClient();
		BufferedReader variabile = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Inserire email e password:");
		String email = variabile.readLine();
		String password = variabile.readLine();
        client.setCredentials(email, password);

        
        // List of repo
        RepositoryService service = new RepositoryService(client);
        List<Repository> repositories = service.getRepositories();
        for (int i = 0; i < repositories.size(); i++)
        {
            Repository get = repositories.get(i);
            System.out.println("Repository Name: " + get.getName());
        }
        
        // Get commit
        CommitService commitService = new CommitService(client);
        for (RepositoryCommit commit : commitService.getCommits(repositories.get(3))) {
            String message = commit.getCommit().getMessage();
            String[] words = message.split(" ");
        	char added_exists = 0;
            for (String word : words) {
        		if (word.equalsIgnoreCase("added")) {
        			added_exists = 1;
        		}
        	}
            if (added_exists == 1) {
            	String url = commit.getCommit().getUrl();
            	String[] urlSplitted = url.split("/");
            	String commitId = urlSplitted[urlSplitted.length-1];
            	System.out.println(commitId);
            }
        }
        
    }
}