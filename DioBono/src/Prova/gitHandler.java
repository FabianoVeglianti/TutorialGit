package Prova;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.ListBranchCommand.ListMode;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Config;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;


public class gitHandler {

	public static void main(String[] args) throws IOException, GitAPIException {
		System.out.println("Hello Git!");
		
		ListCommits();
		
	}
	
	public static void ListCommits() throws IOException, GitAPIException {
		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		repositoryBuilder.setMustExist( true );
		repositoryBuilder.setGitDir(new File("C:/Users/fabia/git/TutorialGit"));
		Repository repository = repositoryBuilder.build();
	
		// Config
		Config cfg = repository.getConfig();
		String name = cfg.getString("user", null, "name");
		System.out.println(name);
		/*
	    RevWalk walk = new RevWalk(git.getRepository());
	    for(Ref branch : branches) {
	        RevCommit commit = walk.parseCommit(branch.getObjectId());
	        if(youngestCommit == null || commit.getAuthorIdent().getWhen().compareTo(
	           youngestCommit.getAuthorIdent().getWhen()) > 0)
	           youngestCommit = commit;
	    }
	    System.out.println(commit.)
		*/
	} 
	
}
