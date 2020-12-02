package common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class FileUtil {
	private static File file = null;

	/**
	 * 디렉토리나 파일의 경로와 이름을 입력받아 File 객체를 리턴한다.
	 *
	 * @param String path   파일 혹은 디렉토리 위치 경로
	 * @param String name   파일 혹은 디렉토리명
	 * @return File
	 */
	public static File checkNull(String path, String name) throws Exception {
		try {
			/* 디렉토리나 파일의 경로와 이름의 null여부를 체크. 조건에 맞는 File을 생성 */
			if (name == "")
				file = new File(path);
			else
				file = new File(path, name);
			return file;
		}
		catch (Exception ex) {
			System.out.println("FileUtil : checkNull()중 에러 발생");
		}
		return file;
	}

	/**
	 * 생성 대상 디렉토리 위치와 파일명으로 해당 정보의 파일을 생성한다.
	 *
	 * @param String filePath   생성 대상 파일 위치 경로
	 * @param String fileName   생성 대상 파일명
	 * @exception IOException
	 */
	public static void fileCreate(String filePath, String fileName) throws Exception {

		/* filePath의 디렉토리 생성 */
		dirCreate(filePath);
		file = new File(filePath, fileName);

		try {
			/* 해당경로에 파일이 존재하지 않으면 새로운 파일을 생성 */
			if (!file.exists())
				file.createNewFile();
		}
		catch (IOException ioe) {
			System.out.println("FileUtil : fileCreate()중 에러 발생");
		}
	}

	/**
	 * 생성 대상 디렉토리 위치와 디렉토리명으로 해당 정보의 디렉토리를 생성한다.
	 *
	 * @param String dirPath    생성 대상 디렉토리 위치 경로
	 * @param String dirName    생성 대상 디렉토리명
	 * @return void
	 */
	public static void dirCreate(String dirPath, String dirName) throws Exception {
		try {
			/* 인자의 null 여부를 체크해 File 생성 */
			file = checkNull(dirPath, dirName);

			/* 해당 경로에 디렉토리가 존재하지 않을 경우 디렉토리 생성 */
			if (!file.isDirectory()) {
				//file.mkdir();
				file.mkdirs();
			}
		}
		catch (Exception ex) {
			System.out.println("FileUtil : dirCreate()중 에러 발생");
		}
	}

	/**
	 * 생성 대상 디렉토리 위치에 빈 디렉토리를 생성한다.
	 *
	 * @param String dirPath    생성 대상 디렉토리 위치 경로
	 * @return void
	 */
	public static void dirCreate(String dirPath) throws Exception {
		try {
			dirCreate(dirPath, "");
		}
		catch (Exception ex) {
			System.out.println("FileUtil : dirCreate()중 에러 발생");
		}
	}

	/**
	 * 디렉토리 혹은 파일의 이름을 수정한다.
	 *
	 * @param String filePath       수정 대상 파일 위치 경로
	 * @param String fileOldName    수정 대상 파일의 현재 이름
	 * @param String fileNewName    수정 대상 파일의 새 이름
	 */
	public static void fileUpdate(String filePath, String fileOldName, String fileNewName) throws Exception {
		try {
			File oldFile = null;
			File newFile = null;

			/* 인자의 null 여부를 체크해 File 생성 */
			oldFile = checkNull(filePath, fileOldName);
			newFile = checkNull(filePath, fileNewName);

			/* 파일이나 디렉토리의 이름을 수정 */
			if (oldFile.renameTo(newFile))
				System.out.println(filePath + "폴더의 " + fileOldName + "파일이 " + fileNewName + "파일로 수정되었습니다.");
		}
		catch (Exception ex) {
			System.out.println("FileUtil : fileUpdate()중 에러 발생");
		}
	}

	/**
	 * 특정 위치에 존재하는 파일을 지정 위치의 디렉토리에 복사한다.
	 *
	 * @param String dirOldPath     복사 대상 파일의 현재 디렉토리 위치 경로
	 * @param String dirNewPath     복사 대상 파일의 새 디렉토리 위치 경로
	 * @param String fileName       복사 대상 파일의 이름
	 * @exception IOException
	 */
	public static void fileCopy(String dirOldPath, String dirNewPath, String fileName) throws Exception {

		File in = null;
		File out = null;

		try {
			/* 인자의 null 여부를 체크해 File 생성 */
			in = checkNull(dirOldPath, fileName);
			out = checkNull(dirNewPath, "");
			
			if(in.exists()) {
				/* 복사 대상 디렉토리가 존재하지 않을시 해당 경로에 디렉토리 생성 */
				if (!out.isDirectory())
					out.mkdirs();
	
				/* 복사 대상 디렉토리에 복사할 파일명으로 File생성 */
				out = new File(dirNewPath, fileName);
	
				/* 복사 대상 파일의 내용을 읽어들여 복사 대상 디렉토리에 파일 복사 */
				FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(out);
	
				byte[] buf = new byte[10*1024];
				int i = 0;
	
				while ( (i = fis.read(buf)) != -1) {
					fos.write(buf, 0, i);
				}
	
				fis.close();
				fos.close();
			}
		}
		catch (IOException ioe) {
			System.out.println("FileUtil : fileCopy()중 에러 발생");
		}
	}

	/**
	 * 특정 위치에 존재하는 파일을 지정 위치의 디렉토리에 새로운 이름으로 복사한다.
	 *
	 * @param String dirOldPath     복사 대상 파일의 현재 디렉토리 위치 경로
	 * @param String dirNewPath     복사 대상 파일의 새 디렉토리 위치 경로
	 * @param String fileName       복사 대상 파일의 이름
	 * @param String fileRename     복사 대상 파일의 새로운이름 
	 * @exception IOException
	 */
	public static void fileCopy(String dirOldPath, String dirNewPath, String fileName, String fileRename) throws Exception {

		File in = null;
		File out = null;

		try {
			/* 인자의 null 여부를 체크해 File 생성 */
			in = checkNull(dirOldPath, fileName);
			out = checkNull(dirNewPath, "");
			
			if(in.exists()) {
				/* 복사 대상 디렉토리가 존재하지 않을시 해당 경로에 디렉토리 생성 */
				if (!out.isDirectory())
					out.mkdirs();
	
				/* 복사 대상 디렉토리에 복사할 파일명으로 File생성 */
				out = new File(dirNewPath, fileRename);
	
				/* 복사 대상 파일의 내용을 읽어들여 복사 대상 디렉토리에 파일 복사 */
				FileInputStream fis = new FileInputStream(in);
				FileOutputStream fos = new FileOutputStream(out);
	
				byte[] buf = new byte[10*1024];
				int i = 0;
	
				while ( (i = fis.read(buf)) != -1) {
					fos.write(buf, 0, i);
				}
	
				fis.close();
				fos.close();
			}
		}
		catch (IOException ioe) {
			System.out.println("FileUtil : fileCopy()중 에러 발생");
		}
	}
	
	/**
	 * 지정 위치의 디렉토리 혹은 파일을 삭제한다.
	 *
	 * @param String path   삭제 대상 파일의 위치 경로
	 * @param String name   삭제 대상 파일명
	 */
	public static void fileDelete(String path, String name) throws Exception {
		try {
			/* 인자의 null 여부를 체크해 File 생성 */
			file = checkNull(path, name);

			if (file.exists()) {

				/* 파일이 존재할 경우 해당 디렉토리가 담고 있는 파일의 리스트를 추출 */
				String[] fileList = file.list();

				/* 파일리스트를 for문으로 돌리면서 디렉토리 내부의 파일을 삭제 */
				if (file.isDirectory() && (fileList.length != 0)) {
					for (int index = 0; index < fileList.length; index++) {
						File chileFile = checkNull(file.getAbsolutePath(), "");
						if (chileFile.isDirectory())

							/* 파일리스트의 인자가 디렉토리일 경우 해당 디렉토리의 내부를 검사*/
							deleteChild(chileFile, fileList[index]);
						else if (chileFile.isFile())
							chileFile.delete();
					}
				}

				/* 리스트 파일을 전부 삭제한 빈 디렉토리 삭제 */
				file.delete();
			}
		}
		catch (Exception ex) {
			System.out.println("FileUtil : fileDelete()중 에러 발생");
		}
	}

	public static void fileDelete(String path) throws Exception {
		try {
			fileDelete(path, "");
		}
		catch (Exception ex) {
			System.out.println("FileUtil : fileDelete()중 에러 발생");
		}
	}

	/**
	 * 디렉토리 삭제 시 디렉토리의 내부에 존재하는 파일을 먼저 삭제하고 빈 디렉토리를 삭제한다.
	 *
	 * @param file      삭제 대상 디렉토리 정보로 생성된 File
	 * @param fileName  삭제 대상 파일명
	 */
	public static void deleteChild(File file, String fileName) throws Exception {
		File childFile = null;
		try {
			/* 검색 대상 파일이 존재하는 디렉토리 일 경우 실행  */
			if (file.exists() && file.isDirectory()) {

				/* 대상 디렉토리 내부 파일의 리스트를 추출  */
				String[] fileList = file.list();

				if (fileList.length != 0) {

					for (int index = 0; index < fileList.length; index++) {

						childFile = checkNull(file.getAbsolutePath(), fileList[index]);

						/* 리스트의 파일을 삭제 */
						if (childFile.isDirectory())
							deleteChild(childFile, fileList[index]);
						else if (childFile.isFile())
							childFile.delete();
					}
				}

				/* 리스트 파일을 전부 삭제한 빈 디렉토리 삭제 */
				file.delete();
			}
		}
		catch (Exception ex) {
			System.out.println("FileUtil : deleteChild()중 에러 발생");
		}
	}


	/**
	 * 단건에 대한 업로드 대상 파일과 업로드 타겟 디렉토리를 입력받아 업로드를 처리하는 메소드
	 * 제약사항 : 로컬만 가능
	 * @param filePath      업로드 대상 파일 정보
	 * @param uploadPath    업로드 타겟 위치 정보
	 * @return String       업로드한 파일의 이름
	 */
	public String fileUpload(String filePath, String uploadPath) throws Exception {
		String uploadFileName = "";
		/* 입력받은 파일명과 경로에 한글이 있을 경우를 대비해 인코딩 */
		String saveFile = filePath;
		String saveDirectory = uploadPath;

		/* 입력받은 파일명은 디렉토리 경로까지 포함하고 있으므로 원래의 파일명만 추출 */
		String fileSep = System.getProperty("file.separator");
		int intStart = saveFile.lastIndexOf(fileSep);
		String fileName = saveFile.substring(intStart + 1, saveFile.length());
		File in = null;
		File out = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			/* 업로드 대상 파일과 업로드 타겟 위치에 대한 File 생성 */
			in = new File(saveFile);
			out = new File(saveDirectory, fileName);

			/* 같은 파일이 존재하면 다른 이름으로 파일 생성*/
			if(out.exists()){

			}

			/* 스트림을 통해 업로드 대상 파일을 업로드 타겟 위치에 복사 */
			fis = new FileInputStream(in);
			fos = new FileOutputStream(out);

			byte[] buf = new byte[10*1024];
			int i = 0;

			while ( (i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}
			uploadFileName = fileName;
		}
		catch(FileNotFoundException fex){

		}
		catch (Exception ex) {

		}
		finally{
			try{
				fis.close();
				fos.close();
			}
			catch (Exception ex) {

			}

		}
		return uploadFileName;
	}

	/**
	 * 단건에 대한 업로드 대상 파일과 업로드 타겟 디렉토리를 입력받아 업로드를 처리하는 메소드
	 * 업로드시 파일이름을 새로 정의된 파일 명으로 변경하여 업로드
	 * 제약사항 : 로컬만 가능
	 * @param filePath      업로드 대상 파일 정보
	 * @param uploadPath    업로드 타겟 위치 정보
	 * @param newFileName   업로드시 생성될 파일의 이름
	 */
	public void fileUpload(String filePath, String uploadPath , String newFileName) throws Exception {
		String saveFile = filePath;
		String saveDirectory = uploadPath;

		try {
			/* 업로드 대상 파일과 업로드 타겟 위치에 대한 File 생성 */
			File in = new File(saveFile);
			File out = new File(saveDirectory, newFileName);

			/* 스트림을 통해 업로드 대상 파일을 업로드 타겟 위치에 복사 */
			FileInputStream fis = new FileInputStream(in);
			FileOutputStream fos = new FileOutputStream(out);

			byte[] buf = new byte[10*1024];
			int i = 0;

			while ( (i = fis.read(buf)) != -1) {
				fos.write(buf, 0, i);
			}

			fis.close();
			fos.close();
		}
		catch (Exception ex) {
		}
	}


	/**
	 * 파일사이즈
	 * @param file
	 * @return int
	 * @throws MainException
	 */
	public int getFileSize(String fileName) throws Exception {
		int fileSize = 0;
		File file = null;
		
		try {
			file = new File(fileName);
			
			if(file.exists()) {
				fileSize = (int)file.length();
			}
		}
		catch (Exception ex) {
		}
		
		return fileSize;
	}
	
    /**
	    * 주어진 파일의 fullpath중 path부분을 제외한 filname part만 분리하여 리턴한다.<BR>
	    * (new File(fullpath)).getName()과 동일하나 File 객체를 사용하지 않고 문자열 패턴만으로 분석한다.<BR>
	    * 만약 fullpath에 / 혹은 \가 존재하지 않는 경우라면 "./" 을 리턴할 것이다.
	    *
	    * @param fullpath Path와 filename으로 이루어진 파일의 fullpath
	    *
	    * @return fullpath중 filename part
	    */
	    public static String getFileNameChop(String fullpath) {
	        if (null == fullpath)
	            return null;
	        fullpath = dosSeperator.matcher(fullpath).replaceAll("/");
	        int pos = fullpath.lastIndexOf("/");
	        if (pos > -1)
	            return fullpath.substring(pos + 1);
	        return fullpath;
	    }

	    /**
	     * 도스 파일시스템의 seperator(\)를 Java Style (/)로 변경하기 위해 사용되는 정규식 패턴
	     */
	    public static final Pattern dosSeperator = Pattern.compile("\\\\");

	    /**
	     * 파일 시스템의 Full Path에서 마지막이 /로 끝나는지를 검사하기 위해 사용되는 정규식 패턴
	     */
	    public static final Pattern lastSeperator = Pattern.compile("/$");

}