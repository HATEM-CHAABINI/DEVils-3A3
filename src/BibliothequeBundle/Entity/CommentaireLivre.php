<?php

namespace BibliothequeBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CommentaireLivre
 *
 * @ORM\Table(name="commentaire_livre", indexes={@ORM\Index(name="fk_commentaire_livre", columns={"id_livre"}), @ORM\Index(name="fk_commentaire_username", columns={"username_locateur"})})
 * @ORM\Entity
 */
class CommentaireLivre
{
    /**
     * @var integer
     *
     * @ORM\Column(name="id", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $id;

    /**
     * @var string
     *
     * @ORM\Column(name="commentaire", type="text", length=65535, nullable=false)
     */
    private $commentaire;

    /**
     * @var \Livre
     *
     * @ORM\ManyToOne(targetEntity="Livre")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="id_livre", referencedColumnName="id")
     * })
     */
    private $idLivre;

    /**
     * @var \Location
     *
     * @ORM\ManyToOne(targetEntity="Location")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="username_locateur", referencedColumnName="username_locateur")
     * })
     */
    private $usernameLocateur;



    /**
     * Get id
     *
     * @return integer
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set commentaire
     *
     * @param string $commentaire
     *
     * @return CommentaireLivre
     */
    public function setCommentaire($commentaire)
    {
        $this->commentaire = $commentaire;

        return $this;
    }

    /**
     * Get commentaire
     *
     * @return string
     */
    public function getCommentaire()
    {
        return $this->commentaire;
    }

    /**
     * Set idLivre
     *
     * @param \BibliothequeBundle\Entity\Livre $idLivre
     *
     * @return CommentaireLivre
     */
    public function setIdLivre(\BibliothequeBundle\Entity\Livre $idLivre = null)
    {
        $this->idLivre = $idLivre;

        return $this;
    }

    /**
     * Get idLivre
     *
     * @return \BibliothequeBundle\Entity\Livre
     */
    public function getIdLivre()
    {
        return $this->idLivre;
    }

    /**
     * Set usernameLocateur
     *
     * @param \BibliothequeBundle\Entity\Location $usernameLocateur
     *
     * @return CommentaireLivre
     */
    public function setUsernameLocateur(\BibliothequeBundle\Entity\Location $usernameLocateur = null)
    {
        $this->usernameLocateur = $usernameLocateur;

        return $this;
    }

    /**
     * Get usernameLocateur
     *
     * @return \BibliothequeBundle\Entity\Location
     */
    public function getUsernameLocateur()
    {
        return $this->usernameLocateur;
    }
}
