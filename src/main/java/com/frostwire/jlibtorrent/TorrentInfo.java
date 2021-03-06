package com.frostwire.jlibtorrent;

import com.frostwire.jlibtorrent.swig.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the information stored in a .torrent file
 *
 * @author gubatron
 * @author aldenml
 */
public final class TorrentInfo {

    private final torrent_info ti;

    public TorrentInfo(torrent_info ti) {
        this.ti = ti;
    }

    /**
     * Load the torrent file and decode it inside the constructor, for convenience.
     * <p/>
     * This might not be the most suitable for applications that
     * want to be able to report detailed errors on what might go wrong.
     *
     * @param torrent
     */
    public TorrentInfo(File torrent) {
        this(bdecode0(torrent));
    }

    public torrent_info getSwig() {
        return this.ti;
    }

    /**
     * The {@link com.frostwire.jlibtorrent.FileStorage} object contains the information on
     * how to map the pieces to files.
     * <p/>
     * It is separated from the torrent_info object because when creating torrents
     * a storage object needs to be created without having a torrent file. When renaming files
     * in a storage, the storage needs to make its own copy of the file_storage in order
     * to make its mapping differ from the one in the torrent file.
     *
     * @return
     */
    public FileStorage getFiles() {
        return new FileStorage(ti, ti.files());
    }

    /**
     * returns the original (unmodified) file storage for this torrent. This
     * is used by the web server connection, which needs to request files with the original
     * names. Filename may be chaged using ``torrent_info::rename_file()``.
     *
     * @return
     */
    public FileStorage getOrigFiles() {
        return new FileStorage(ti, ti.orig_files());
    }

    /**
     * Adds a tracker to the announce-list.
     *
     * @param url
     */
    public void addTracker(String url) {
        ti.add_tracker(url);
    }

    /**
     * Adds a tracker to the announce-list. The ``tier`` determines the order in
     * which the trackers are to be tried.
     *
     * @param url
     * @param tier
     */
    public void addTracker(String url, int tier) {
        ti.add_tracker(url, tier);
    }

    /**
     * will return a sorted vector of ``announce_entry``.
     * <p/>
     * Each announce entry contains a string, which is the tracker url, and a tier index. The
     * tier index is the high-level priority. No matter which trackers that works or not, the
     * ones with lower tier will always be tried before the one with higher tier number.
     *
     * @return
     */
    public List<AnnounceEntry> getTrackers() {
        announce_entry_vector v = ti.trackers();
        int size = (int) v.size();

        List<AnnounceEntry> l = new ArrayList<AnnounceEntry>(size);
        for (int i = 0; i < size; i++) {
            l.add(new AnnounceEntry(v.get(i)));
        }

        return l;
    }

    /**
     * Adds one url to the list of url seeds. Currently, the only transport protocol supported for the url
     * is http.
     *
     * @param url
     */
    public void addUrlSeed(String url) {
        ti.add_url_seed(url);
    }

    /**
     * Adds one url to the list of url seeds. Currently, the only transport protocol supported for the url
     * is http.
     * <p/>
     * The ``extern_auth`` argument can be used for other athorization schemese than
     * basic HTTP authorization. If set, it will override any username and password
     * found in the URL itself. The string will be sent as the HTTP authorization header's
     * value (without specifying "Basic").
     *
     * @param url
     * @param externAuth
     */
    public void addUrlSeed(String url, String externAuth) {
        ti.add_url_seed(url, externAuth);
    }

    /**
     * Adds one url to the list of url seeds. Currently, the only transport protocol supported for the url
     * is http.
     * <p/>
     * he ``extern_auth`` argument can be used for other athorization schemese than
     * basic HTTP authorization. If set, it will override any username and password
     * found in the URL itself. The string will be sent as the HTTP authorization header's
     * value (without specifying "Basic").
     * <p/>
     * The ``extra_headers`` argument defaults to an empty list, but can be used to
     * insert custom HTTP headers in the requests to a specific web seed.
     *
     * @param url
     * @param externAuth
     * @param extraHeaders
     */
    public void addUrlSeed(String url, String externAuth, List<Pair<String, String>> extraHeaders) {
        string_string_pair_vector v = new string_string_pair_vector();
        for (int i = 0; i < extraHeaders.size(); i++) {
            v.add(extraHeaders.get(i).to_string_string_pair());
        }
        ti.add_url_seed(url, externAuth, v);
    }

    /**
     * Adds one url to the list of http seeds. Currently, the only transport protocol supported for the url
     * is http.
     *
     * @param url
     */
    public void addHttpSeed(String url) {
        ti.add_url_seed(url);
    }

    /**
     * Adds one url to the list of http seeds. Currently, the only transport protocol supported for the url
     * is http.
     * <p/>
     * The ``extern_auth`` argument can be used for other athorization schemese than
     * basic HTTP authorization. If set, it will override any username and password
     * found in the URL itself. The string will be sent as the HTTP authorization header's
     * value (without specifying "Basic").
     *
     * @param url
     * @param externAuth
     */
    public void addHttpSeed(String url, String externAuth) {
        ti.add_url_seed(url, externAuth);
    }

    /**
     * Adds one url to the list of http seeds. Currently, the only transport protocol supported for the url
     * is http.
     * <p/>
     * he ``extern_auth`` argument can be used for other athorization schemese than
     * basic HTTP authorization. If set, it will override any username and password
     * found in the URL itself. The string will be sent as the HTTP authorization header's
     * value (without specifying "Basic").
     * <p/>
     * The ``extra_headers`` argument defaults to an empty list, but can be used to
     * insert custom HTTP headers in the requests to a specific web seed.
     *
     * @param url
     * @param externAuth
     * @param extraHeaders
     */
    public void addHttpSeed(String url, String externAuth, List<Pair<String, String>> extraHeaders) {
        string_string_pair_vector v = new string_string_pair_vector();
        for (int i = 0; i < extraHeaders.size(); i++) {
            v.add(extraHeaders.get(i).to_string_string_pair());
        }
        ti.add_url_seed(url, externAuth, v);
    }

    /**
     * returns all url seeds and http seeds in the torrent. Each entry
     * is a ``web_seed_entry`` and may refer to either a url seed or http seed.
     *
     * @return
     */
    public List<WebSeedEntry> getWebSeeds() {
        web_seed_entry_vector v = ti.web_seeds();
        int size = (int) v.size();

        List<WebSeedEntry> l = new ArrayList<WebSeedEntry>(size);
        for (int i = 0; i < size; i++) {
            l.add(new WebSeedEntry(v.get(i)));
        }

        return l;
    }

    /**
     * The total number of bytes the torrent-file represents (all the files in it).
     *
     * @return
     */
    public long getTotalSize() {
        return ti.total_size();
    }

    /**
     * The number of byte for each piece.
     * <p/>
     * The difference between {@link #getPieceSize(int)} and {@link #getPieceLength()} is that
     * {@link #getPieceSize(int)} takes the piece index as argument and gives you the exact size
     * of that piece. It will always be the same as {@link #getPieceLength()} except in the case
     * of the last piece, which may be smaller.
     *
     * @return
     */
    public int getPieceLength() {
        return ti.piece_length();
    }

    /**
     * The total number of pieces.
     *
     * @return
     */
    public int getNumPieces() {
        return ti.num_pieces();
    }

    /**
     * returns the info-hash of the torrent.
     *
     * @return
     */
    public Sha1Hash getInfoHash() {
        return new Sha1Hash(ti.info_hash());
    }

    /**
     * If you need index-access to files you can use the ``num_files()`` and ``file_at()``
     * to access files using indices.
     *
     * @return
     */
    public int getNumFiles() {
        return ti.num_files();
    }

    /**
     * This function will map a piece index, a byte offset within that piece and
     * a size (in bytes) into the corresponding files with offsets where that data
     * for that piece is supposed to be stored.
     *
     * @param piece
     * @param offset
     * @param size
     * @return
     * @see com.frostwire.jlibtorrent.FileSlice
     */
    public ArrayList<FileSlice> mapBlock(int piece, long offset, int size) {
        file_slice_vector v = ti.map_block(piece, offset, size);
        int vSize = (int) v.size();

        ArrayList<FileSlice> l = new ArrayList<FileSlice>(vSize);
        for (int i = 0; i < vSize; i++) {
            l.add(new FileSlice(v.get(i)));
        }

        return l;
    }

    /**
     * This function will map a range in a specific file into a range in the torrent.
     * The {@code offset} parameter is the offset in the file, given in bytes, where
     * 0 is the start of the file.
     * <p/>
     * The input range is assumed to be valid within the torrent. {@code offset + size}
     * is not allowed to be greater than the file size. {@code index}
     * must refer to a valid file, i.e. it cannot be {@code >= getNumFiles()}.
     *
     * @param file
     * @param offset
     * @param size
     * @return
     * @see com.frostwire.jlibtorrent.PeerRequest
     */
    public PeerRequest mapFile(int file, long offset, int size) {
        return new PeerRequest(ti.map_file(file, offset, size));
    }

    /**
     * Returns the SSL root certificate for the torrent, if it is an SSL
     * torrent. Otherwise returns an empty string. The certificate is
     * the public certificate in x509 format.
     *
     * @return
     */
    public String getSslCert() {
        return ti.ssl_cert();
    }

    /**
     * Returns true if this torrent_info object has a torrent loaded.
     * <p/>
     * This is primarily used to determine if a magnet link has had its
     * metadata resolved yet or not.
     *
     * @return
     */
    public boolean isValid() {
        return ti.is_valid();
    }

    /**
     * returns true if this torrent is private. i.e., it should not be
     * distributed on the trackerless network (the kademlia DHT).
     *
     * @return
     */
    public boolean isPrivate() {
        return ti.priv();
    }

    /**
     * returns true if this is an i2p torrent. This is determined by whether
     * or not it has a tracker whose URL domain name ends with ".i2p". i2p
     * torrents disable the DHT and local peer discovery as well as talking
     * to peers over anything other than the i2p network.
     *
     * @return
     */
    public boolean isI2P() {
        return ti.is_i2p();
    }

    public int getPieceSize(int index) {
        return ti.piece_size(index);
    }

    /**
     * takes a piece-index and returns the 20-bytes sha1-hash for that
     * piece and ``info_hash()`` returns the 20-bytes sha1-hash for the info-section of the
     * torrent file.
     *
     * @param index
     * @return
     */
    public Sha1Hash getHashForPiece(int index) {
        return new Sha1Hash(ti.hash_for_piece(index));
    }

    /**
     * returns the name of the torrent.
     * <p/>
     * the name is an UTF-8 encoded strings.
     *
     * @return
     */
    public String getName() {
        return ti.name();
    }

    /**
     * returns the creation date of
     * the torrent as time_t (`posix time`_). If there's no time stamp in the torrent file,
     * a value of zero is returned.
     *
     * @return
     */
    public int getCreationDate() {
        return ti.get_creation_date();
    }

    /**
     * returns the creator string in the torrent. If there is no creator string
     * it will return an empty string.
     *
     * @return
     */
    public String getCreator() {
        return ti.creator();
    }

    /**
     * returns the comment associated with the torrent. If there's no comment,
     * it will return an empty string.
     * <p/>
     * the comment is an UTF-8 encoded strings.
     *
     * @return
     */
    public String getComment() {
        return ti.comment();
    }

    /**
     * Generates a magnet URI from the specified torrent. If the torrent
     * is invalid, null is returned.
     * <p/>
     * For more information about magnet links, see magnet-links_.
     *
     * @return
     */
    public String makeMagnetUri() {
        return ti.is_valid() ? libtorrent.make_magnet_uri(ti) : null;
    }

    public Entry toEntry() {
        return new Entry(new create_torrent(ti).generate());
    }

    public byte[] bencode() {
        return toEntry().bencode();
    }

    public static TorrentInfo bdecode(byte[] data) {
        return new TorrentInfo(bdecode0(data));
    }

    private static torrent_info bdecode0(File file) {
        try {
            byte[] data = Files.bytes(file);
            return bdecode0(data);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't decode data from file: " + file, e);
        }
    }

    private static torrent_info bdecode0(byte[] data) {
        bdecode_node n = new bdecode_node();
        error_code ec = new error_code();
        int ret = bdecode_node.bdecode(Vectors.bytes2char_vector(data), n, ec);

        if (ret == 0) {
            ec.clear();
            torrent_info ti = new torrent_info(n, ec);
            if (ec.value() != 0) {
                throw new IllegalArgumentException("Can't decode data: " + ec.message());
            }
            return ti;
        } else {
            throw new IllegalArgumentException("Can't decode data: " + ec.message());
        }
    }
}
